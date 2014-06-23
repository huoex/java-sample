QA001
RuntimeException需要try catch吗？

java 编译器允许不catch

QA002
接到一个异常，如何判断是要处理，还是要往上抛？

QA003
throws抛出的异常必需被捕获吗

1.你可以定义方法的时候加上显式的需要抛出的异常 
Java代码  
public returnType methodName(args) throws YourException{   
...   
}  
1.如果异常是继承RuntimeException，则不需要强制你写try catch语句来保证抛出的
异常得到处理。如果继承的是Exception，则一定需要try catch语句保证异常得到处理，
或者在该方法中显式声明抛出该异常。 
2.通常如果你的方法显式声明了需要抛出的异常，编译器会提示你需要使用try catch语句
来处理这些异常或者声明抛出，否则会有编译错误。对于有些异常是继承RuntimeException的，
这些异常是引发unchecked Exception的主要原因，编译器不会提示，
但是你也可以使用try catch来捕捉处理。通常API文档都会提示可能会抛出的
runtimeException，那在写代码的时候就要小心处理了。

QA004
Exception和继承自Exception的RuntimeException有什么区别

Java compiler要求所有的Exception 要么被catch,要么被throw，
除非这是一个RuntimeExeption (e instanceof RuntimeException)。
也就是说，通常的Exception一定要被处理，也即我们所说的 checked exception，
而RuntimeException不强制要求处理，（当然你自己要处理也可以），
所以我们称为unchecked exception。

RuntimeException一般由JVM抛出，即即使你不检查，JVM也会在运行时检查到并抛出  。

RuntimeException 是属于unchecked （java 编译器允许不catch）表示一类 未知的不确定的
只有在运行时才会出现的异常。 
而非RuntimeException 是checked （java 编译器必须要求 catch），大概指一类可以预知的，
当发生异常后知道如何处理的异常，所以需要捕获。 

PQ001
异常的种类
java异常可以分成两大类：Exception和RuntimeException
(虽然RuntimeException是从Exception继承的)。
超类是Throwable。

PQ002
对于异常要么处理（try catch），要么接着抛（throws）
