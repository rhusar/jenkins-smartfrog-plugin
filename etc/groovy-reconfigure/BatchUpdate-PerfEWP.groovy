/*
 * JBoss, Home of Professional Open Source.
 * Copyright 2006, Red Hat Middleware LLC, and individual contributors
 * as indicated by the @author tags. See the copyright.txt file in the
 * distribution for a full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
import hudson.model.*
import builder.smartfrog.*
import hudson.tasks.*
import java.util.regex.Pattern


def projects = Hudson.instance.getAllItems(Project.class)


print "["
for(project in projects) {
   if ("${project.name}".startsWith("ewp-50-failover-")) {
      print "\"${project.name}\","
   }
}
print "]"

def jobs = ["ewp-50-failover-beans-proxy-jvmkill-async-full","ewp-50-failover-http-jvmkill-async-full","ewp-50-failover-http-jvmkill-sync-buddy","ewp-50-failover-http-shutdown-sync-total","ewp-50-failover-http-undeploy-async-buddy"]

for (job in jobs){
   item = Hudson.instance.getItem(job)

   println "\n* processing ${item.name}"

   builders = item.buildersList

   // SCM
   scm = item.scm
   locs = scm.@locations
   def delLoc = null
   for(loc in locs){
      if(loc.@remote.contains("script")){
         println "Removing " + loc.@remote
         delLoc = loc
      }
   }
   scm.@locations = locs.minus(delLoc)

   // update maven plugin
   mavenb = builders.get(Maven.DESCRIPTOR)
   mavenb.@pom = "maven/eap-51/hudson-mod_cluster.xml"

   // SF BUILDER
   sfBuilder = builders.get(SmartFrogBuilder.DESCRIPTOR)
   sfBuilder.@sfUserHome = "etc/maven/eap-51/target/dependency"
   sfBuilder.jvmArgs  = "-server -Xmx4g -XX:+UseLargePages"

   // make the workspace delete after the run
   list = item.getPublishersList()
   if(!list.contains(hudson.plugins.ws_cleanup.WsCleanup.DESCRIPTOR)){
      list.add(new hudson.plugins.ws_cleanup.WsCleanup())
   }

   // persist to file (helps on hudson restart ;)
   item.save()
}

