<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <title id="top_title">1초만 기다리면</title>
    <link rel="stylesheet" href="/css/wait_style.css">
</head>
<body>
	<div class="container">
        <p id="head_text">
            1초만 기다리면 페이지를 찾을 수 있어요!
        </p>
    </div>
    <img src="/img/wait01.webp" class="cimg" id="wait_photo">
    <div class="container">
        <div class="box"></div>
        <div class="box" width="60%">
            <p id="text1" class="main_text" style="display:block">
                왜냐면 이제부터 기다림이 1초를 넘을 때마다<br>

                대가리를 존나 쎄게 쳐서 제 머릿속을 뒤죽박죽 엉망진창으로 만들 거거든요! <br><br><br>


                기다렸다는 것이 기억이 나지 않는다면<br>

                안 기다린 게 아닐까요?<br>

                그렇게 페이지가 나올때까지 1초가 지나기 전에 기억을 지운다면<br><br><br>


                1초만에 페이지가 나오는 것이 아닐까요???<br>

                1초만 기다리면 페이지가 나온다니! <br><br>


                생각만 해도 너무 즐거워요~!!!
            </p>
            <p id="text2" class="main_text" style="display:none">
                외나먼 이 제부더 기다 림이 1초 를 넘을대마다<br><br><br>

                대가 리를 존나 세게 처서 제머 리소글 뒤주뱍주 어마지차으로 만드 거거드요?<br><br><br><br><br>

                기다러다는 거시 기억이 나지 안는다먼<br><br><br>

                안 기다린 게 아니 가요!<br><br><br>

                그러헤 페이지가 나 올대가지 1초가지나기 저헤 기어흘 지운다면<br><br><br>

                1초마헤 페이지가 나오는는 거히 아니가요!!!<br><br><br><br><br>

                1 초만 기다리허 페이지가 나온다니?<br><br><br>

                생강만 해 도 너무 즐거 어요~???
            </p>
            <p id="text3" class="main_text_v2" style="display:none">
                <span class="red_under">왜!</span>!!<span class="darkblue">!!</span>!!!!<span class="darkslateblue">냐</span><span class="dimgrey">!!!!!</span>!!!면!!​!!!​!!! 이히이이이이이이이이이이이이이이이이이이이이이!?!?@?@?!?&gt;@&lt;!!! <br><br><br>

                머리이이이이이이이이¡!!!!!¡¡!!¡!¡!¡!!!! <br><br><br>

                하루하루!!!!!¡¡!!!!!!#^#*¤​♧☆¥​¥°$^*¿¡!?!!?!¡​¿​¡?¡ <br><br><br>
                
                끼얏호우~~~!!!!~~~!!~
            </p>
            <p id="text4" class="main_text_v2" style="display:none">
                404 not found
            </p>
        </div>
        <div class="box"></div>
    </div>
    <div class="container">
        <button class="custom-button" id="next_button" value="">1초는 이미 지난거 같다만...</button>
    </div>
</body>
<script>
    const nbutton = document.getElementById("next_button");
    let page_step = 1; //1~4
    let isRepeat = 1;
    let change_speed = 5; //bigger, slower
    //1C = 255, 6C = 1530
    //255 510 765 1020 1275 1530
    change_head();

    nbutton.addEventListener('click', function() {
        //let page_step = document.getElementById("next_button").value * 1;

        page_step += 1;
        if(page_step > 4) { //마지막 버튼 누를때
        	history.go(-1);
        }
        
        document.getElementById("next_button").value = page_step;
        change_photo(page_step);
        change_paragraph(page_step);
        //change main
        change_button(page_step);
        scrollToTop();
    });

    // function change_page() {
    //     //let page_step = document.getElementById("next_button").value * 1;

    //     page_step += 1;
    //     if(page_step > 4) page_step=4;
        
    //     document.getElementById("next_button").value = page_step;
    //     change_photo(page_step);
    //     //change main
    //     change_button(page_step);
    // }

    function change_photo(ps) {
        let photo_src = "/img/wait01.webp"
        switch (ps) {
            case 1:
            case 2:
                photo_src = "/img/wait01.webp"
                break;
            case 3:
                photo_src = "/img/wait03.jpeg"
                break;
            case 4:
                photo_src = "/img/wait04.png"
                break;
            default:
                break;
        }
        
        document.getElementById("wait_photo").src = photo_src;
    }

    function change_paragraph(ps) {
        document.getElementById("text1").style.display = "none";
        document.getElementById("text2").style.display = "none";
        document.getElementById("text3").style.display = "none";
        document.getElementById("text4").style.display = "none";
        switch (ps) {
            case 1:
                document.getElementById("text1").style.display = "block";
                break;
            case 2:
                document.getElementById("text2").style.display = "block";
                break;
            case 3:
                document.getElementById("text3").style.display = "block";
                break;
            case 4:
                document.getElementById("text4").style.display = "block";
                break;
            default:
                break;
        }
    }

    function change_button(ps) {
        let button_text = "";

        switch (ps) {
            case 1:
                button_text = "1초는 이미 지난거 같다만..."
                break;
            case 2:
                button_text = "？？？뭐？？？"
                break;
            case 3:
                button_text = "이 무슨...."
                break;
            case 4:
                button_text = "........."
                break;
            default:
                break;
        }
        
        document.getElementById("next_button").innerHTML = button_text;
    }

    function scrollToTop() {
        // 페이지를 최상단으로 스크롤
        window.scrollTo({
            top: 0,
            //behavior: 'smooth' // 부드럽게 스크롤 이동
        });
    }

    function sleep(ms) {
        return new Promise(resolve => setTimeout(resolve, ms));
    }

    async function change_head() {
        const ht = document.getElementById("head_text");
        ht.style.fontSize = "30px";

        while(isRepeat == 1) {
            ht.style.color = calc_rgb();
            await sleep(10);
        }        
    }

    function calc_rgb() {
        const now = new Date();
        const origin_timestamp = now.getTime();
        let timestamp = origin_timestamp / change_speed;
        //console.log(timestamp); // 밀리초 단위의 타임스탬프 출력

        const M = 255;
        let color_hash = timestamp % 1530;

        let color_r = M;
        let color_g = M;
        let color_b = M;

        if (color_hash <= M) {
            color_r = M;
            color_g = color_hash;
            color_b = 0;
        }
        else if (color_hash <= M * 2) {
            color_r = color_hash * -1 + M * 2;
            color_g = M;
            color_b = 0;
        }
        else if (color_hash <= M * 3) {
            color_r = 0;
            color_g = M;
            color_b = color_hash - M * 2;
        }
        else if (color_hash <= M * 4) {
            color_r = 0;
            color_g = color_hash * -1 + M * 4;
            color_b = M;
        }
        else if (color_hash <= M * 5) {
            color_r = color_hash - M * 4;
            color_g = 0;
            color_b = M;
        }
        else if (color_hash <= M * 6) {
            color_r = M;
            color_g = 0;
            color_b = color_hash * -1 + M * 6;
        }

        return "rgb(" + color_r + ", " + color_g + ", " + color_b + ")";
    }

</script>
</html>