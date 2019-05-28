/**
 * 文档手册：https://www.runoob.com/w3cnote/html5-canvas-intro.html
 */

// 需要等页面canvas元素生成之后，才可以在上面绘画。
window.onload = function () {
    var c = document.getElementById("myCanvas");
    // getContext("2d") 对象是内建的 HTML5 对象，
    // 拥有多种绘制路径、矩形、圆形、字符以及添加图像的方法。
    var ctx = c.getContext("2d");

    /**
     * 1. canvas坐标
     *  canvas是一个二维网格，左上为（0,0）
     *  fillRect(x,y,width,height) 方法定义了矩形当前的填充方式。
     *  只支持一种原生的图形绘制：矩形。
     *   所有其他图形都至少需要生成一种路径 (path)。
     */
    ctx.fillStyle = "#FF0000";  // 设置图形的填充颜色,默认设置是#000000（黑色）
    // ctx.strokeStyle = color 设置图形轮廓的颜色
    ctx.fillRect(0, 0, 150, 75);

    /**
     * 2. 路径
     *  一个路径，甚至一个子路径，都是闭合的。
     *  moveTo(x,y) 线条开始坐标
     *  lineTo(x,y) 线条结束坐标
     *  绘制线条我们必须使用到 "ink" 的方法，就像stroke().
     *  ctx.beginPath();
     *  1) 创建路径起始点
     *  2) 调用绘制方法去绘制出路径
     *  3) 把路径封闭 ctx.closePath();
     *  4) 一旦路径生成，通过描边或填充路径区域来渲染图形。
     */
    // ctx.beginPath(); //新建一条path
    ctx.moveTo(150, 75); //把画笔移动到指定的坐标
    ctx.lineTo(200, 100); //绘制一条从当前位置到指定坐标(200, 50)的直线.
    // ctx.closePath();
    ctx.stroke(); //绘制路径。描边
    // ctx.fill(); //填充闭合区域。如果path没有闭合，则fill()会自动闭合路径

    /**
     * 3. 绘制圆形
     *   使用 arc() 方法 arc(x, y, r, startAngle, endAngle, anticlockwise)
     *   0 弧度是指的 x 轴正方形。
     */
    ctx.beginPath();
    ctx.arc(205, 250, 50, 0, 2 * Math.PI);
    ctx.stroke();

    /**
     * 4. canvas 文本
     *  font - 定义字体
     *  fillText(text,x,y) - 在 canvas 上绘制实心的文本
     *  strokeText(text,x,y) - 在 canvas 上绘制空心的文本
     */
    ctx.font = "30px Arial";
    ctx.fillText("小灰灰", 200, 200);
    ctx.strokeText("小灰灰", 220, 220);

    /**
     * 5. canvas 渐变
     *  createLinearGradient(x,y,x1,y1) - 创建线条渐变
     *  createRadialGradient(x,y,r,x1,y1,r1) - 创建一个径向渐变
     *  注：create的东西是新产生的，需要有引用。
     */
    var grd = ctx.createLinearGradient(400, 400, 600, 600);
    grd.addColorStop(0, "red");
    grd.addColorStop(1, "black");
    ctx.fillStyle = grd;
    ctx.fillRect(400, 400, 200, 200);
    var grd2 = ctx.createRadialGradient(100, 300, 20, 100, 300, 50,);
    grd2.addColorStop(0, "white");
    grd2.addColorStop(1, "blue");
    ctx.fillStyle = grd2;
    ctx.fillRect(50, 250, 100, 100);

    /**
     * 6. canvas 图像
     *  把一幅图像放置到画布上，drawImage(image,x,y)
     *  drawImage(image, x, y, width, height) 来控制 当像 canvas 画入时应该缩放的大小。
     *  drawImage 还提供切片slice功能，
     *  注：这里动态创建的图片会存在偶尔刷新较快时，加载失灵的情况
     *  怀疑和图片的创建有关。
     *  其中一种解决方式，把元素创建提前，或者直接在html中放置，然后隐藏。
     */
        // document.querySelector("img"); // 用来选择页面上已有元素
        // var img = document.createElement("img");
        // img.setAttribute("src","1.PNG");
    var img = new Image();
    img.src = "1.PNG"; // 保证在 img 绘制完成之后再 drawImage。
    img.onload = () => {
        ctx.drawImage(img, 300, 300);
    };

    /**
     *  7. 状态的保存和恢复,栈类似
     *   save() 和 restore() 当前画面应用的所有样式和变形的一个快照。
     */

    /**
     * 8. 变形
     *  移动 translate(x, y) 移动 canvas 的原点到指定的位置
     *  旋转 rotate(angle)
     *  尺度 scale(x, y)
     *  变形矩阵  transform (变形矩阵)
     */

    /**
     * 9. 合成
     *  globalCompositeOperation
     *  覆盖 "source-over"; //全局合成操作
     *  交集 source-in
     *  取补 source-out
     */

    /**
     * 10. 控制动画
     * 定时执行重绘的方法
     *  setInterval()
     *  setTimeout()
     *  requestAnimationFrame()
     */
    // let sun;
    // let earth;
    // let moon;
    // function init(){
    //     sun = new Image();
    //     earth = new Image();
    //     moon = new Image();
    //     sun.src = "1.PNG";
    //     earth.src = "1.PNG";
    //     moon.src = "1.PNG";
    //
    //     // let canvas = document.querySelector("#solar");
    //     // ctx = canvas.getContext("2d");
    //
    //     sun.onload = function (){
    //         draw()
    //     }
    //
    // }
    // init();
    // function draw(){
    //     ctx.clearRect(0, 0, 300, 300); //清空所有的内容
    //     /*绘制 太阳*/
    //     ctx.drawImage(sun, 0, 0, 300, 300);
    //
    //     ctx.save();
    //     ctx.translate(150, 150);
    //
    //     //绘制earth轨道
    //     ctx.beginPath();
    //     ctx.strokeStyle = "rgba(255,255,0,0.5)";
    //     ctx.arc(0, 0, 100, 0, 2 * Math.PI)
    //     ctx.stroke()
    //
    //     let time = new Date();
    //     //绘制地球
    //     ctx.rotate(2 * Math.PI / 60 * time.getSeconds() + 2 * Math.PI / 60000 * time.getMilliseconds())
    //     ctx.translate(100, 0);
    //     ctx.drawImage(earth, -12, -12)
    //
    //     //绘制月球轨道
    //     ctx.beginPath();
    //     ctx.strokeStyle = "rgba(255,255,255,.3)";
    //     ctx.arc(0, 0, 40, 0, 2 * Math.PI);
    //     ctx.stroke();
    //
    //     //绘制月球
    //     ctx.rotate(2 * Math.PI / 6 * time.getSeconds() + 2 * Math.PI / 6000 * time.getMilliseconds());
    //     ctx.translate(40, 0);
    //     ctx.drawImage(moon, -3.5, -3.5);
    //     ctx.restore();
    //
    //     requestAnimationFrame(draw);
    // }

    // 案例2：模拟时钟
    init();

    function init(){
        // let canvas = document.querySelector("#solar");
        // let ctx = canvas.getContext("2d");
        draw(ctx);
    }

    function draw(ctx){
        requestAnimationFrame(function step(){
            drawDial(ctx); //绘制表盘
            drawAllHands(ctx); //绘制时分秒针
            requestAnimationFrame(step);
        });
    }
    /*绘制时分秒针*/
    function drawAllHands(ctx){
        let time = new Date();

        let s = time.getSeconds();
        let m = time.getMinutes();
        let h = time.getHours();

        let pi = Math.PI;
        let secondAngle = pi / 180 * 6 * s;  //计算出来s针的弧度
        let minuteAngle = pi / 180 * 6 * m + secondAngle / 60;  //计算出来分针的弧度
        let hourAngle = pi / 180 * 30 * h + minuteAngle / 12;  //计算出来时针的弧度

        drawHand(hourAngle, 60, 6, "red", ctx);  //绘制时针
        drawHand(minuteAngle, 106, 4, "green", ctx);  //绘制分针
        drawHand(secondAngle, 129, 2, "blue", ctx);  //绘制秒针
    }
    /*绘制时针、或分针、或秒针
     * 参数1：要绘制的针的角度
     * 参数2：要绘制的针的长度
     * 参数3：要绘制的针的宽度
     * 参数4：要绘制的针的颜色
     * 参数4：ctx
     * */
    function drawHand(angle, len, width, color, ctx){
        ctx.save();
        ctx.translate(150, 150); //把坐标轴的远点平移到原来的中心
        ctx.rotate(-Math.PI / 2 + angle);  //旋转坐标轴。 x轴就是针的角度
        ctx.beginPath();
        ctx.moveTo(-4, 0);
        ctx.lineTo(len, 0);  // 沿着x轴绘制针
        ctx.lineWidth = width;
        ctx.strokeStyle = color;
        ctx.lineCap = "round";
        ctx.stroke();
        ctx.closePath();
        ctx.restore();
    }

    /*绘制表盘*/
    function drawDial(ctx){
        let pi = Math.PI;

        ctx.clearRect(0, 0, 300, 300); //清除所有内容
        ctx.save();

        ctx.translate(150, 150); //一定坐标原点到原来的中心
        ctx.beginPath();
        ctx.arc(0, 0, 148, 0, 2 * pi); //绘制圆周
        ctx.stroke();
        ctx.closePath();

        for (let i = 0; i < 60; i++){//绘制刻度。
            ctx.save();
            ctx.rotate(-pi / 2 + i * pi / 30);  //旋转坐标轴。坐标轴x的正方形从 向上开始算起
            ctx.beginPath();
            ctx.moveTo(110, 0);
            ctx.lineTo(140, 0);
            ctx.lineWidth = i % 5 ? 2 : 4;
            ctx.strokeStyle = i % 5 ? "blue" : "red";
            ctx.stroke();
            ctx.closePath();
            ctx.restore();
        }
        ctx.restore();
    }
};

