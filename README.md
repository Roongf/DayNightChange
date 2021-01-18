# DayNightChange

  一个简单的日间/夜间模式无缝切换的功能，无需重启App，可定制化。
  
  支持设置背景图(android:background)、文字颜色(android:textColor)、图片(android:src)。

# 效果
![image](https://github.com/Roongf/DayNightChange/blob/master/device-2021-01-18-154847.gif)  

# How to use:

 1.NightModeConfigManager.init(context) 初始化 context 用来记录App的模式  
 2.NightModeConfigManager.instance.initDayNightMode()：设置上一次记录下来的App的日间/夜间模式(建议直接放在YourApplication上)  
 3.NightModeConfigManager.instance.changeDayNightMode(): 切换时调用  
 4.不同布局的添加的背景(background)，不管是图片形式还是颜色形式，只需要继承IDayNightSwitcher去调用resetDayNightThemeStyle()方式实现具体的，目前只支持android:background、android:text_color、android:src的形式。dayNightChangedBackground()、dayNightChangeTextColor()、dayNightChangeSrc()，对应相应的模式切换。  
 5.图片形式的只需要在drawable-night文件夹中放入同名文件，自动读取日/夜间模式的对应图片  
 6.颜色形式的只需要在values-night文件夹下的colors.xml文件中定义同名的颜色名，自动读取日/夜间模式的对应颜色
