package exception;

/*
异常处理机制中的finalTy块
finally块是异常处理机制的最后一块，它可以跟在try之后或者最后一个catch之后。
finally可以保证只要程序执行到try语句块中，无论try中是否出现异常，finally最终都会必定执行。

通常我们将释放资源这类操作放在finally中确保运行，例如I0操作后最终的close()调用
 */
public class FinallyDemo {
    public static void main(String[] args) {
        System.out.println("程序开始了。。。");

        try {
            String line = "null";
            System.out.println(line.length());

            // 在try语句块中，出错位置以下的代码均不会执行
            System.out.println("!!!!!!!");

            return;
        }catch(Exception e){
            System.out.println("通用的异常处理方式");
        }finally { //进行异常处理后，finally语句块中的内容一定会执行
            System.out.println("finally中的代码执行啦");
        }

        System.out.println("程序结束啦。。。");
    }
}
