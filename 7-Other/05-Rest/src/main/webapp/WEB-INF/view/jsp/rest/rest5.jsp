<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>

<html>
<head>
<script src="http://code.jquery.com/jquery-2.2.3.js"
			  integrity="sha256-laXWtGydpwqJ8JA+X9x2miwmaiKhn8tVmOVEigRNtP4="
			  crossorigin="anonymous"></script>
<script>
(function($){
    $.fn.serializeObject = function(){

        var self = this,
            json = {},
            push_counters = {},
            patterns = {
                "validate": /^[a-zA-Z][a-zA-Z0-9_]*(?:\[(?:\d*|[a-zA-Z0-9_]+)\])*$/,
                "key":      /[a-zA-Z0-9_]+|(?=\[\])/g,
                "push":     /^$/,
                "fixed":    /^\d+$/,
                "named":    /^[a-zA-Z0-9_]+$/
            };


        this.build = function(base, key, value){
            base[key] = value;
            return base;
        };

        this.push_counter = function(key){
            if(push_counters[key] === undefined){
                push_counters[key] = 0;
            }
            return push_counters[key]++;
        };

        $.each($(this).serializeArray(), function(){

            // skip invalid keys
            if(!patterns.validate.test(this.name)){
                return;
            }

            var k,
                keys = this.name.match(patterns.key),
                merge = this.value,
                reverse_key = this.name;

            while((k = keys.pop()) !== undefined){

                // adjust reverse_key
                reverse_key = reverse_key.replace(new RegExp("\\[" + k + "\\]$"), '');

                // push
                if(k.match(patterns.push)){
                    merge = self.build([], self.push_counter(reverse_key), merge);
                }

                // fixed
                else if(k.match(patterns.fixed)){
                    merge = self.build([], k, merge);
                }

                // named
                else if(k.match(patterns.named)){
                    merge = self.build({}, k, merge);
                }
            }

            json = $.extend(true, json, merge);
        });

        return json;
    };
})(jQuery);


jQuery(document).ready(function() {



jQuery("#btn1").click(function() {
  var data = jQuery("#form1").serializeObject();
  console.log(data);
  console.log(JSON.stringify( data ));

  console.log(jQuery("#form1").attr("action"));

  $.ajax({
    type: "POST",
    url: jQuery("#form1").attr("action"),
    headers: {"Content-Type":"application/json"},
    "data": JSON.stringify( data ),
    success: function(response) {
        console.log(response);
        console.log(response.speed);
        jQuery("body").appendTo("<p>"+speed+ "</p>");
    },
    dataType: "json"
  });

});

});

</script>
</head>
<body>
<a href="<c:url value='/rest5' />">/home</a><br />
<form id="form1" action="<c:url value='/rest5' />" method="POST">
    <table>
    <tr><th>Speed</th><td><input type="text" value="99" name="speed" /></td></tr>
    <tr><th>Color</th><td><input type="text" value="GREEN" name="color" /></td></tr>

    </table>
<button type="button" id="btn1">Btn1</button>
</form>

</body>
</html>