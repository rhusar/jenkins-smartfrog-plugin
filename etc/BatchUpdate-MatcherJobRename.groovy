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

for(project in projects) {
   if ("${project.name}".startsWith("eap-50-mod_cluster")) {
      println "${project.name} ->"

      def String name=project.name

      rex = /([a-zA-Z]+)-5(0)-(mod_cluster)-(.*)-([a-zA-Z0-9]+)-([a-zA-Z0-9_]+)/
      matcher = ( name =~ rex )

      //println name
      def result = "eap-5x-mod_cluster-" + matcher[0][5] +"-"+matcher[0][6] +"-" + matcher[0][4]

      println result

      if (result.length() != name.length()) {
         println "> SIZES DONT MATCH <"
      }

      // rename the job
      item = Hudson.instance.getItem(name)
      item.renameTo(result)
      item.save()
      println "Renamed!"

      println " "
   }
}