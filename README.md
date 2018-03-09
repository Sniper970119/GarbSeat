#Sniper
 java抢座位，自动抢某学校的图书馆座位
 
 *免责声明：仅供研究使用，请勿进行非法用途。*
 
 
 ### 环境要求
 1. JDK 1.8 以及上
 2. HtmlUnit包
 3. 百度OCR 包
 
 #### 安装[HtmlUnit](http://htmlunit.sourceforge.net/)
 ```
 1. 下载HtmlUnit
 2. 使用编译器导入外部jar包
 
```
 #### 安装[百度OCR](https://ai.baidu.com/download?sdkId=1)
 ```
 1. 下载HtmlUnit
 2. 使用编译器导入外部jar包
 ```
 
 其中
 
 JudgeCode中是对验证码的识别，使用百度OCR进行识别，中间的百度OCR的ID等需要自己填写。
 
 Main是对网站源码进行分析处理，使用WebClient包模拟浏览器进行点击，对验证码进行保存，并调用识别。
 
 如果有更多问题欢迎加我的QQ一起探讨
 
 QQ：1846799608  添加时备注是在github看到的
 