Class的装载分了三个阶段，loading，linking和initializing

Class.forName(className)装载的class已经被初始化
ClassLoader.loadClass(className)装载的class还没有被link
一般情况下，这两个方法效果一样，都能装载Class
如果程序依赖于Class是否被初始化，就必须用Class.forName(name)了。