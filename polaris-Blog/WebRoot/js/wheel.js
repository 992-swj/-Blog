//鼠标滑过变颜色   
$(document).ready(function() {
		$("#middle_left ul>li").hover(function() {
			$(this).css({
				"background-color" : "#bce672"
			});
		}, function() {
			$(this).css({
				"background-color" : "#E9EAED"
			});
		});
	});
   //轮播
    var index2 = 0;
    //鐐瑰嚮鐐�
    $(".tab-btn .btn").click(function () {
        index2 = $(this).index();//鑾峰彇鐐瑰嚮璇ュ厓绱犱笅褰�
        $(this).addClass("active").siblings().removeClass("active");
        $(".item").eq(index2).fadeIn().siblings().fadeOut();
    });
    $(".lr-tab .right").click(function () {
        index2 ++;
        if (index2 >4){ index2 = 0;}
        $(".item").eq(index2).fadeIn().siblings().fadeOut();
        $(".tab-btn .btn").eq(index2).addClass("active").siblings().removeClass("active");

    });
    $(".lr-tab .left").click(function () {
        index2--;
        if(index2 < 0){index2 = 4;}
        $(".item").eq(index2).fadeIn().siblings().fadeOut();
        $(".tab-btn .btn").eq(index2).addClass("active").siblings().removeClass("active");

    });
    var time2 = setInterval(function () {
        index2 ++;
        if (index2 >4){ index2 = 0;}
        $(".item").eq(index2).fadeIn().siblings().fadeOut();
        $(".tab-btn .btn").eq(index2).addClass("active").siblings().removeClass("active");
    },2500);
