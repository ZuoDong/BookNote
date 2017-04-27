## 1.4 依赖倒置原则
1.模块之间不发生直接的依赖关系，其依赖关系是通过接口或抽象类产生的；即面向接口编程，面向抽象编程。
## 4原型模式
通过clone()来实现，它是Object中的方法，只有实现了Clonable的对象才能使用clone()方法，否则会抛异常。
通常分为浅克隆和深克隆，建议开发用深克隆(引用型字段也要拷贝page71)。克隆不会走构造方法（注意！！！）。
## 6抽象工厂
Android中使用的并不多，使用抽象工厂来创建对象，实现了接口与实现的分离
## 7策略模式
-针对同一类型问题的多种处理方式，仅仅具体行为有差别时。
-需要安全的封装多种同一种操作时。
-出现同一抽象类有多个子类，而又需要使用if-else或者switch-case来选择具体子类时。
## 8状态模式
与策略模式基本相同，不同之处在于策略倾向于封装方法，而状态倾向于区分不同的对象。
主要是用来减少if-else的使用
实例:WIFI的状态，开机时，驱动未加载，驱动已加载
## 10解释器模式
使用比较少，一般用于解释文法规则，构建抽象语法树，了解即可。
## 11命令模式
将一个请求封装成一个对象，从而让用户使用不同的请求把客户端参数化；对请求排队或者记录日志，以及支持可撤销的操作。
PS:抽取代码封装，然后添加功能
## 12观察者模式
AndroidEventBus项目地址为:https://github.com/bboyfeiyu/AndroidEventBus
实例：BroadcastReciver用来接收消息
## 13备忘录模式
在不破坏封装的条件下，通过备忘录对象存储另外一个对象内部的状态快照，在合适的时候还原状态
实例: onSaveInstanceState和onRestoreInstanceState
## 14迭代器模式
提供一种方法顺序访问一个容器对象中的各个元素，有不需要暴漏该对象的内部表示。（实际使用不多）
实例：iterator,Cursor等等
## 15模板方法模式
模板方法中父类定义步骤逻辑，抽取公共方法，子类实现相关细节。代码中的重构。
实例: AsyncTask的步骤（execute-->onPreExecute-->doInBackground-->onPostExecute）
Activity的执行步骤（ActivityThread.main-->Activity.onCreate-->Activity.onStart-->Activity.onResume）
复习：Page-296ImageLoader升级
# 16访问者模式
访问者模式使用的频率不高，用于对象结构比较稳定，对同一对象进行不同操作的情况
实例：编译时注解(APT)使用实例，ButterKnife，Dagger,R密码etrofit;作者的项目SimpleDagger:
     https://github.com/bboyfeiyu/InjectDagger
## 18代理模式
实质就是控制对象的访问。可分为：远程代理；虚拟代理；保护代理；智能引用
实例：AIDL以及Binder机制的讲解，Page351 通知栏实战
## 19组合模式
表示对象的部分-整体的层次结构，类似于文件和文件夹的样式。具体又分为透明组合模式和安全组合模式。
都实现了同一接口，区别在于是否在子类中添加方法以区别整体和部分。
实例：View和ViewGroup就是安全组合模式
## 20适配器模式
page375：ListView解析 page380:RecyclerView解析
## 21装饰者模式‘
动态的给给对象添加一些额外的功能。注意和代理模式进行区别：是否进行功能的增强
实例：Context和ContextImpl和ContextWrapper的关系
## 22享元模式
使用缓存存储对象。使用场景：1.系统中存在大量相似的对象2.内部状态与环境无关的对象3.需要缓冲池
实例：Message的使用其实是用一个链表来维护的
拓展：深入Android消息机制
# 23外观模式
为复杂子系统提供一个统一接口，用于与外部交互,各种SDK的实现都会用到
实例：ContextImpl封装了系统的服务，用户只需要和context接口进行打交道
拓展：Android资源的加载与配置(插件模式详见:https://github.com/singwhatiwanna/dynamic-load-apk)
# 24桥接模式
将抽象部分与实现部分分离，使他们都可以独立的进行变化。
实例：Window与WindowManger，WindowManger里面有个Window实例