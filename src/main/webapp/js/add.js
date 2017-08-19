$(document).ready(function () {
    
    
    $.ajax({
        url:"/language/allLanguage",
        type:"POST",
        data:{},
        success:function (result) {

            renderTemplate(result.extend.languages);
        }
        
        
    })

    function renderTemplate(result) {
        var t = $("#add-template").html();

        var f = Handlebars.compile(t);

        var h = f(result);

        $("#languageId").html(h);

    }
    
})