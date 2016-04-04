<%@ include file="../init.jspf" %>

<h1>Autocomplete example</h1>

<input type="text" id="acomplete" />

<script type="text/javascript">

jQuery(document).ready(function($) {
    $("#acomplete").autocomplete({
    source: "/autocomplete/countries"
    });
});

</script>