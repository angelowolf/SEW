<#--
/*
 * $Id$
 *
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
-->
<html>
    <style>
        .debugTable {
            border-style: solid;
            border-width: 1px;
        }
        
        .debugTable td {
            border-style: solid;
            border-width: 1px;
        }
        
        .nameColumn {
            background-color:#CCDDFF;
        }
        
        .valueColumn {
            background-color: #CCFFCC;
        }
        
        .nullValue {
            background-color: #FF0000;
        }
        
        .typeColumn {
            background-color: white;
        }
        
        .emptyCollection {
            background-color: #EEEEEE;
        }
    </style>
    <script language="JavaScript" type="text/javascript">
        // Dojo configuration
        djConfig = {
            isDebug: false,
            bindEncoding: "UTF-8"
            ,baseRelativePath: "${base}/struts/dojo/"
            ,baseScriptUri: "${base}/struts/dojo/"
        };
    </script>



    <script language="JavaScript" type="text/javascript"  src="${base}/struts/dojo/dojo.js"></script>
    <script>
        dojo.require("dojo.io.*");
        
        function expand(src, path) {
          var baseUrl = location.href;
          var i = baseUrl.indexOf("&object=");
          baseUrl = (i > 0 ? baseUrl.substring(0, i) : baseUrl) + "&object=" + path;
          if (baseUrl.indexOf("decorate") < 0) {
             baseUrl += "&decorate=false";
          } 
          dojo.io.bind({
            url: baseUrl,
            load : function(type, data, evt) {
              var div = document.createElement("div");
              div.innerHTML = data;
              src.parentNode.appendChild(div);
              
              src.innerHTML = "Collapse";
              var oldonclick = src.onclick;
              src.onclick = function() {
                src.innerHTML = "Expand";
                src.parentNode.removeChild(div);
                src.onclick = oldonclick;
              };
            }
          });
        }
    </script>

<body>
    ${debugHtml}
</body>
</html>