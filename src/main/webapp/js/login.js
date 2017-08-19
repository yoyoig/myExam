$(document).ready(function () {


    $("#login").click(function () {

        $.ajax({
            url:"${pageContext.request.contextPath}/customer/customerLogin",
            type: "POST",
            data: {
                firstName:$("#text1").val()
            },
            success: function (result) {
                var isLogin = eval("(" + result + ")");
                if(isLogin['isLogin']){
                window.location.href="${pageContext.request.contextPath}/main.jsp";
                }else {

                window.location.href="${pageContext.request.contextPath}/login.jsp";
                }


            }

        })

    })

})