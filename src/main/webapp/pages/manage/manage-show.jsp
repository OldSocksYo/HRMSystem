<%--
  Created by IntelliJ IDEA.
  User: Yong
  Date: 2020/9/20
  Time: 22:02
--%>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<html>
<head>
    <title>manage</title>
    <%@ include file="/pages/common/head.jsp"%>
    <link rel="stylesheet" href="pages/static/css/manage.css">
<%--    以下四个引入，是用来支持轮播图实现的--%>
<%--    <link rel="stylesheet" href="https://unpkg.com/swiper/swiper-bundle.css">--%>
<%--    <link rel="stylesheet" href="https://unpkg.com/swiper/swiper-bundle.min.css">--%>
<%--    <script src="https://unpkg.com/swiper/swiper-bundle.js"> </script>--%>
<%--    <script src="https://unpkg.com/swiper/swiper-bundle.min.js"> </script>--%>
<%--    上面的下载到本地了--%>
    <link rel="stylesheet" href="pages/static/css/swiper-bundle.min.css">
    <script src="pages/static/js/swiper-bundle.min.js"> </script>
    <style>
        .swiper-container {
            margin-top: 9%;
            width: 100%;
            height: 50%;
        }
        .swiper-slide {
            text-align: center;
            font-size: 18px;
            background: #fff;
            /* Center slide text vertically */
            display: -webkit-box;
            display: -ms-flexbox;
            display: -webkit-flex;
            display: flex;
            -webkit-box-pack: center;
            -ms-flex-pack: center;
            -webkit-justify-content: center;
            justify-content: center;
            -webkit-box-align: center;
            -ms-flex-align: center;
            -webkit-align-items: center;
            align-items: center;
        }
    </style>
</head>
<body>
<%@ include file="/pages/common/title-nav.jsp"%>
<div id="main">
    <%@ include file="/pages/common/left-nav.jsp"%>
    <div id="right">
        <div class="swiper-container">
            <span style="margin: 0 43%;padding: 10px; font-size: 20px; color: gray;">入职员工展示</span>
            <div class="swiper-wrapper">

            </div>
            <!-- Add Arrows -->
            <div class="swiper-button-next"></div>
            <div class="swiper-button-prev"></div>
        </div>
    </div>
</div>
</body>
<script type="text/javascript">

    $.ajax({
        url: "uploadPic/getAllEmployeePic",
        type: 'get',
        //服务器返回的数据的类型
        dataType: 'json',
        success:  function(data) {
            data.forEach(function(item){
                const img = document.createElement('img');
                img.src= item.imgUrl
                img.classList = "swiper-slide"
                // document.querySelector(".swiper-wrapper").append(img)
                $(".swiper-wrapper").append(img);
            });
            //轮播图的设置得放在图片全部加载完之后（不然就会出问题，应该是轮播图插件内部实现的问题）
            var swiper = new Swiper('.swiper-container', {
                navigation: {
                    nextEl: '.swiper-button-next',
                    prevEl: '.swiper-button-prev',
                },
                autoplay: {
                    delay: 2000,
                    stopOnLastSlide: false,
                    disableOnInteraction: true,
                },
                loop: true,
                effect : 'coverflow',
                slidesPerView: 3,
                centeredSlides: true,
                coverflowEffect: {
                    rotate: 30,
                    stretch: 10,
                    depth: 60,
                    modifier: 2,
                    slideShadows : true
                },
            });
        }
    });
</script>
</html>
