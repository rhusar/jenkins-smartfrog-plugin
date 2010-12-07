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
   if ("${project.name}".startsWith("eap-5x-mod_cluster-")) {
      print "\"${project.name}\","
   }
}
print "]"


//def jobs = ["eap-5x-failover-ejb3-jvmkill-buddy-async","eap-5x-failover-ejb3-jvmkill-buddy-sync","eap-5x-failover-ejb3-jvmkill-total-async","eap-5x-failover-ejb3-jvmkill-total-sync","eap-5x-failover-ejb3-random-jvmkill-buddy-async","eap-5x-failover-ejb3-random-jvmkill-buddy-sync","eap-5x-failover-ejb3-random-jvmkill-total-async","eap-5x-failover-ejb3-random-jvmkill-total-sync","eap-5x-failover-ejb3-random-shutdown-buddy-async","eap-5x-failover-ejb3-random-shutdown-buddy-sync","eap-5x-failover-ejb3-random-shutdown-total-async","eap-5x-failover-ejb3-random-shutdown-total-sync","eap-5x-failover-ejb3-random-undeploy-buddy-async","eap-5x-failover-ejb3-random-undeploy-buddy-sync","eap-5x-failover-ejb3-random-undeploy-total-async","eap-5x-failover-ejb3-random-undeploy-total-sync","eap-5x-failover-ejb3-shutdown-buddy-async","eap-5x-failover-ejb3-shutdown-buddy-sync","eap-5x-failover-ejb3-shutdown-total-async","eap-5x-failover-ejb3-shutdown-total-sync","eap-5x-failover-ejb3-undeploy-buddy-async","eap-5x-failover-ejb3-undeploy-buddy-sync","eap-5x-failover-ejb3-undeploy-total-async","eap-5x-failover-ejb3-undeploy-total-sync"]

def jobs = ["eap-5x-mod_cluster-rhel4-i386-failover","eap-5x-mod_cluster-rhel4-i386-load-calculation","eap-5x-mod_cluster-rhel4-i386-undeploy","eap-5x-mod_cluster-rhel4-x86_64-failover","eap-5x-mod_cluster-rhel4-x86_64-load-calculation","eap-5x-mod_cluster-rhel4-x86_64-perf","eap-5x-mod_cluster-rhel4-x86_64-perf-mod_jk","eap-5x-mod_cluster-rhel4-x86_64-shutdown","eap-5x-mod_cluster-rhel4-x86_64-undeploy","eap-5x-mod_cluster-rhel5-i386-failover","eap-5x-mod_cluster-rhel5-i386-load-calculation","eap-5x-mod_cluster-rhel5-i386-undeploy","eap-5x-mod_cluster-rhel5-x86_64-failover","eap-5x-mod_cluster-rhel5-x86_64-failover-ha","eap-5x-mod_cluster-rhel5-x86_64-failover-NEW","eap-5x-mod_cluster-rhel5-x86_64-failover-TEMPLATING","eap-5x-mod_cluster-rhel5-x86_64-load-calculation","eap-5x-mod_cluster-rhel5-x86_64-undeploy","eap-5x-mod_cluster-solaris10-i386-failover","eap-5x-mod_cluster-solaris10-i386-load-calculation","eap-5x-mod_cluster-solaris10-i386-undeploy","eap-5x-mod_cluster-solaris10-sparc64-failover","eap-5x-mod_cluster-solaris10-sparc64-shutdown","eap-5x-mod_cluster-solaris10-sparc64-undeploy","eap-5x-mod_cluster-solaris10-x86_64-failover","eap-5x-mod_cluster-solaris10-x86_64-load-calculation","eap-5x-mod_cluster-solaris10-x86_64-undeploy","eap-5x-mod_cluster-solaris9-i386-failover","eap-5x-mod_cluster-solaris9-i386-load-calculation","eap-5x-mod_cluster-solaris9-i386-undeploy","eap-5x-mod_cluster-solaris9-sparc-failover","eap-5x-mod_cluster-solaris9-sparc64-failover","eap-5x-mod_cluster-solaris9-sparc64-shutdown","eap-5x-mod_cluster-solaris9-sparc64-undeploy","eap-5x-mod_cluster-windows-i386-failover","eap-5x-mod_cluster-windows-i386-load-calculation","eap-5x-mod_cluster-windows-i386-shutdown","eap-5x-mod_cluster-windows-i386-undeploy","eap-5x-mod_cluster-windows-x86_64-failover","eap-5x-mod_cluster-windows-x86_64-load-calculation","eap-5x-mod_cluster-windows-x86_64-shutdown","eap-5x-mod_cluster-windows-x86_64-undeploy","eap-5x-mod_cluster-windows2003-i386-failover","eap-5x-mod_cluster-windows2003-x86_64-failover","eap-5x-mod_cluster-windows2008-i386-failover","eap-5x-mod_cluster-windows2008-x86_64-failover"]

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

