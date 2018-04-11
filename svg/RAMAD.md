## svg入门
### svg的基本图形和属性
#### 基本图形
* <rect>        矩形
* <circle>	     圆
* <ellipse>	    椭圆
* <line>		直线	  
* <polyline>    折线
* <polygon>		多边形
#### 基本属性
* fill          填充颜色
* stroke		描边颜色
* stroke-width  描边粗细
* tansform        变换

### svg的基本操作的API
#### 创建图形
* document.createElementNS(ns,tagName)
#### 添加图形
* element.appendChild(childElement)
#### 设置/获取属性
* element.setAttribute(name,value)
* element.getAttribute(name)

## SVG中的坐标系统
* width,height 控制视窗
* SVG代码 定义世界
* viewBox,preserveAspectRation-控制视野