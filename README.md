# Sniper
 java抢座位，自动抢某学校的图书馆座位

 *免责声明：仅供研究使用，请勿进行非法用途。*


 ![](https://github.com/Sniper970119/GarbSeat/blob/master/image/show01.png)

 ![](https://github.com/Sniper970119/GarbSeat/blob/master/image/show02.png)

 ![](https://github.com/Sniper970119/GarbSeat/blob/master/image/show03.png)

 ![](https://github.com/Sniper970119/GarbSeat/blob/master/image/show04.png)


 ### 环境要求
 1. JDK 1.8 以及上
 2. HtmlUnit包
 3. 百度OCR 包

 #### [安装HtmlUnit](http://htmlunit.sourceforge.net/)
 ```
 1. 下载HtmlUnit
 2. 使用编译器导入外部jar包

```
 #### [安装百度OCR](https://ai.baidu.com/download?sdkId=1)
 ```
 1. 下载SDK
 2. 使用编译器导入外部jar包
 ```

 ### 原理

 采用java浏览器模拟用户访问网站并进行点击，多线程任务，以达到“抢”的效果。

 #### 其中

 JudgeCode中是对验证码的识别，使用百度OCR进行识别，中间的百度OCR的ID等需要自己填写。

 Main是对网站源码进行分析处理，使用WebClient包模拟浏览器进行点击，对验证码进行保存，并调用识别。




 ### 更新

 #### GUI-2.0
 直观的显示已经提交过多少次。

 添加用户权限判断，添加试用帐号和正式账号，获取网络时间对帐号权限进行检查。

 #
 如有指教的大佬，欢迎加我QQ联系。

 QQ：1846799608 加的时候请说明是在github上看到的，谢谢。
