QA001
为何要用泛型
避免类型转换

QA002
java中有哪些泛型的应用
List<E>

QA003
定义一个泛型方法


QA004
public List<? extends Map<String, ?>> 如何理解呢

List 是一种集合，里面可以存放各种 Object 对象。尖括号框起来则限定了它可以存放的数据
类型。例如 List<Integer> 就只能存放 Integer 对象，
你这里的 List<? extends Map<String, ?>> 则表示它只能存放 ? extends Map<String, ?> 
的对象。

然后再看 ? extends Map<String, ?> 表示什么？
Map 是映射，包含一个 key，一个 value，因此你可以分别指定 key 和 value 的类型。
第一个 String 指定的是 key 的类型，表示 key 只能是 String 对象的引用，
后面的 ？ 指定的是 value 类型，表示 value 可以是任意对象（没有限制）。

然后 ? extends Map 表示这应该是一个 Map 类本身或其子类的对象，例如 HashMap。

总而言之，这表示，返回一个存储着 key 是 String 类型的 Map 或其子类型的 List


PQ001
<T> <?>

T 是一种类型
？是泛指（就是通配符）