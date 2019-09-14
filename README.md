# 031702203
## 题目：损坏的地址簿

公司给实习生小王安排了一个任务，要求将一份客户地址规范化处理，地址簿原先是这样的：
王先生,13756899511,福建福州闽侯上街镇福州大学.陈先生,15063321552,福建省福州市鼓楼区鼓西街道湖滨路233号.
这样的地址不够规范，公司要求小王将地址规范化为如下的字典格式，并存储为json文件：
[{"姓名":"王先生","手机":"13756899511","地址":["福建省","福州市","闽侯县","上街镇","福州大学"]},
{"姓名":"陈先生","手机":"15063321552","地址":["福建省","福州市","鼓楼区","鼓西街道","湖滨路233号"]}]
可是小王不仅没完成任务，还把原始文件弄乱了，手机号码被混杂在地址数据中，请帮小王恢复文件并完成他的任务。

### 文件现状：
李四,福建省福州13756899511市鼓楼区鼓西街道湖滨路110号湖滨大厦一层.
张三,福建福州闽13599622362侯县上街镇福州大学10#111.
王五,福建省福州市鼓楼18960221533区五一北路123号福州鼓楼医院.
小美,北京市东15822153326城区交道口东大街1号北京市东城区人民法院.
小陈,广东省东莞市凤岗13965231525镇凤平路13号.

### 请把文件格式化为如下形式：
[{"姓名"':"李四","手机":"13756899511","地址":["福建省","福州市","鼓楼区","鼓西街道", "湖滨路110号湖滨大厦一层"]},
{"姓名":"张三","手机":"13599622362","地址":["福建省","福州市","闽侯县","上街镇", "福州大学10#111"]},
{"姓名":"王五","手机":"18960221533","地址":["福建省","福州市","鼓楼区","","五一北路123号福州鼓楼医院"]},
{"姓名":"小美","手机":"15822153326","地址":["北京","北京市","东城区","","交道口东大街1号北京市东城区人民法院"]},
{"姓名":"小陈","手机":"13965231525","地址":["广东省","东莞市","","凤岗镇","凤平路13号"]}]

### 请注意：
1.直辖市与一般城市的匹配区别，如样例中的小美。
2.手机号码一定不会和地址中的数字相邻，即不会出现福州市西二环路11380502116922号或者福州大学30#31395521336233这样的情况。
3.地址最终格式应为["直辖市/省","直辖市/市","区/县/县级市","街道/镇/乡","详细地址"]
4.该难度题目不会出现违背题目规则的异常样例。

当你把该任务做好之后，产品经理突发奇想，让你进一步匹配详细地址，进而区分出详细地址中的街道、道路名、门牌号等信息，文件则因变成：
[{"姓名":"李四","手机":"13756899511","地址":["福建省","福州市","鼓楼区","鼓西街道","湖滨路","110号","湖滨大厦一层"]},
{"姓名":"张三","手机":"13599622362","地址":["福建省","福州市","闽侯县","上街镇","","","福州大学10#111"]},
{"姓名":"王五","手机":"18960221533","地址":["福建省","福州市","鼓楼区","","五一北路","123号","福州鼓楼医院"]},
{"姓名":"小美","手机":"15822153326","地址":["北京","北京市","东城区","","交道口东大街","1号","北京市东城区人民法院"]},
{"姓名":"小陈","手机":"13965231525","地址":["广东省","东莞市","","凤岗镇","凤平路","13号",""]}]

### ps：
但是呢张三同志我对不起你 我还不会分出你呜呜呜 大概搞定了 但是呢 如果出现一些比较难的emmmmmmmm很明显它还不行
可以生成文件了 但是文件还得是本地文件 路径还不能改
