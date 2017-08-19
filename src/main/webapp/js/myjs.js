$(document).ready(function () {
    $("#items").click(function () {
        $("#personDiv").css("display","none")
        $("#itemsDiv").css("display","block")
    })
    $("#info").click(function () {
        $("#itemsDiv").css("display","none")
        $("#personDiv").css("display","block")
    })


    //添加
    var $form =  $("#itemsForm")
    $("#addItem").click(function () {
        $form.attr("action","addFilm.jsp");
        $form.submit();

    })

    //用户修改邮箱非空验证
    $("#email").bind("blur",function () {
        $email = $("#email").val()
        var reg =  /^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/;
        if($email == ""){

            $("#emailInfo").html("邮箱不能为空！")
            $("#btn").attr("disabled", true);
        }else {
            if(reg.test($email)) {
                $("#emailInfo").html("")
                $("#btn").attr("disabled", false);
            }else{
                $("#emailInfo").html("请输入正确的邮箱格式！")
                $("#btn").attr("disabled", true);
            }
        }

    })





    //电影名验证
    $("#nameKey").bind("blur",function () {
        var $name = $("#nameKey").val()
        if($name==""){
            $("#titleIsEx").css("color","red")
            $("#titleIsEx").html("电影名不能为空！")
            $("#btn").attr("disabled", true);
        }else {

            $.ajax({
                url: "/film/filmName",
                type: "POST",
                data: {"filmName": $name},
                success: function (result) {
                    var nameJson = eval("(" + result + ")")

                    if (nameJson['isEx']) {
                        $("#titleIsEx").css("color", "green")
                        $("#titleIsEx").html("电影名可用！")
                        $("#btn").attr("disabled", false);
                    } else {
                        $("#titleIsEx").css("color", "red")
                        $("#titleIsEx").html("电影名不可用！")
                        $("#btn").attr("disabled", true);
                    }

                }

            })
        }
    })

    //描述验证
    $("#description").bind("blur",function () {
        var description = $("#description").val();
        if(description==""){
            $("#descriptionIsEx").css("color", "red")
            $("#descriptionIsEx").html("描述不能为空！")
            $("#btn").attr("disabled", true);
        }else{
            $("#descriptionIsEx").html("")
            $("#btn").attr("disabled", false);
        }
    })

    //语言验证
    $("#languageId").bind("blur",function () {
        var languageId = $("#languageId").val();
        if(languageId==""){
            $("#languageIdInfo").css("color", "red")
            $("#languageIdInfo").html("请选择语言！")
            $("#btn").attr("disabled", true);

        }else{
            $("#languageIdInfo").html("")
            $("#btn").attr("disabled", false);
        }
    })





})