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

def jobs = ["radotest"]

for (job in jobs){
   item = Hudson.instance.getItem(job)
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


   // SF BUILDER
   sfBuilder = builders.get(SmartFrogBuilder.DESCRIPTOR)
   sfBuilder.@sfUserHome = "maven/eap-51/target/dependency"
   sfBuilder.jvmArgs  = "-server -Xmx4g -XX:+UseLargePages"
   //println sfBuilder.scriptContent.readLines().get(0)
   sfBuilder.@scriptContent = sfBuilder.scriptContent.replaceAll("org/jboss/smartfrog/test/ejb3/template-failover-ejb3-order.sf", "org/jboss/smartfrog/eap/failover/template-http-order.sf")

   /*def newcont =
   for (String line in sfBuilder.scriptContent.readLines()) {

   }*/

   sfBuilder.hosts = "perf09 perf01 perf02 perf03 perf04 perf05"

   // update maven plugin
   mavenb = builders.get(Maven.DESCRIPTOR)
   mavenb.@pom = "maven/eap-51/hudson-failover.xml"


   // persist to file (helps on hudson restart ;)
   item.save()
}

