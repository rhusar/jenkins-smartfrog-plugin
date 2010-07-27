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

import hudson.model.Hudson
import hudson.model.Project
def projects = Hudson.instance.getAllItems(Project.class)

for(project in projects) {

   if ("${project.name}".contains("eap-5x-failover")) {
      println "${project.name}"

    item = Hudson.instance.getItem(job)
    builders = item.buildersList
    sfBuilder = builders.get(SmartFrogBuilder.DESCRIPTOR)
    println sfBuilder.@sfUserHome
    sfBuilder.@sfUserHome += "/test"
    scm = item.scm
    locs = scm.@locations
    for(loc in locs){
        println loc.@remote
        loc.@remote += "/test"
    }
    item.save()
      
   }

}


   /*
	println "\n* ${project.name}"
	def logRotator = project.getLogRotator()
	if(logRotator == null){
		println "\tRetention policy is not set  =>  setting it to default values."
		logRotator = new LogRotator(DEFAULT_DAYS_TO_KEEP, DEFAULT_NUM_TO_KEEP);
		setRotator(project, logRotator)
	} else if((logRotator.numToKeep < 0) || (logRotator.numToKeep > DEFAULT_NUM_TO_KEEP)) {
		println "\tSetting retention policy to default values."
		logRotator = new LogRotator(logRotator.daysToKeep, DEFAULT_NUM_TO_KEEP);
		setRotator(project, logRotator)
	} else {
		println "\tRetention policy is set to [Days to keep builds: ${logRotator.daysToKeep!=-1?logRotator.daysToKeep:'not set'}, Max # of builds to keep: ${logRotator.numToKeep!=-1?logRotator.numToKeep:'not set'}]."
	}
   */


/* vojta:
import hudson.model.*
import builder.smartfrog.*

jobs = ["vojta-smartFrog-test"]
for(job in jobs){
    item = Hudson.instance.getItem(job)
    builders = item.buildersList
    sfBuilder = builders.get(SmartFrogBuilder.DESCRIPTOR)
    println sfBuilder.@sfUserHome
    sfBuilder.@sfUserHome += "/test"
    scm = item.scm
    locs = scm.@locations
    for(loc in locs){
        println loc.@remote
        loc.@remote += "/test"
    }
    item.save()
}

*/

def setRotator(project, logRotator) {
  //some types of project don't support this operation
  try {
    project.setLogRotator(logRotator)
  } catch (UnsupportedOperationException e) {}
}