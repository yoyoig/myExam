$(document).ready(function () {

    toPage(1);

    //跳转页面
    $("#skipPage").bind("blur",function () {

            $("#skipPage").val("");
            $("#skipPage").css("color","black")
    })

    //根据result将template写入到页面
    function renderTemplate(result) {
        var t = $("#main-template").html();
        var f = Handlebars.compile(t);
        var h = f(result);
        $("#main_template").empty();
        $("#main_template").html(h);

    }

    //通过ajax跳转页面
    function toPage(pageNum) {
        $.ajax({
            url:"/film/queryAll",
            type: "POST",
            data: {"currentPage":pageNum},
            success: function (result) {

                renderTemplate(result);
                addClick();
            }
        })
    }

    //页码跳转
    function addClick() {

    $(".prePage").bind("click",function () {
        $prePage = $(".prePage input").val();
        toPage($prePage);

    })

    $(".nextPage").bind("click",function () {
        $nextPage = $(".nextPage input").val();
        toPage($nextPage);

    })

    $(".firstPage").bind("click",function () {
        toPage(1);

    })

    $(".endPage").bind("click",function () {
        $endPage = $(".endPage input").val();
        toPage($endPage);

    })


    $("#skip").bind("click",function () {
        toPage($("#skipPage").val());
    })



    }


})