# DayNightChange

  一个简单的日间/夜间模式无缝切换的功能，可定制化。
  
  支持设置背景图(android:background)、文字颜色(android:textColor)、图片(android:src)。

# 效果
![image][]
# How to use:

 1.NightModeConfigManager.init(context) 初始化 context 用来记录App的模式  
 2.NightModeConfigManager.instance.initDayNightMode()：设置上一次记录下来的App的日间/夜间模式(建议直接放在YourApplication上)  
 3.NightModeConfigManager.instance.changeDayNightMode(): 切换时调用
