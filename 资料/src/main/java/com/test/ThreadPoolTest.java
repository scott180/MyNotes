package com.test;

import java.util.concurrent.*;

/**
 * 线程池测试
 *
 * @author xyq
 * @date 2020/4/18 17:21
 */
public class ThreadPoolTest {

    /**
     * io密集型和cpu密集型线程池的选用
     * cpu密集型  ncpu+1
     * io密集型   ncpu*2
     */

    private static int threadNum = 0;
    private static int count = 0;
    private static int ncpu = Runtime.getRuntime().availableProcessors();
    private static ThreadPoolExecutor executor = new ThreadPoolExecutor(4, 6, 20L,
            TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(5), new ThreadPoolExecutor.AbortPolicy());

    public static ThreadPoolExecutor executPool = new ThreadPoolExecutor(2, 4, 60, TimeUnit.SECONDS,
            new ArrayBlockingQueue<Runnable>(3),
            new ThreadFactory() {
                public Thread newThread(Runnable r) {
                    return new Thread(r, "t_pl_pool_" + (threadNum++));
                }
            },
            new ThreadPoolExecutor.DiscardOldestPolicy());

    /**
     * 提交任务
     * 1、放入核心线程 corePoolSize 执行
     * 2、核心线程满了，放入队列中等待执行
     * 3、队列满了，最大线程 maximumPoolSize 未满，创建新的线程执行
     * 4、队列满了，最大线程也满了，会执行拒绝策略
     *
     * <p><存活时间 是线程执行结束后非核心线程的存活时间。核心线程根据 allowCoreThreadTimeOut 确定</p>
     *
     * <p>
     * 拒绝策略有四种：
     * 第一种 AbortPolicy:不执行新任务，直接抛出异常，提示线程池已满
     * 第二种 DiscardPolicy:不执行新任务，也不抛出异常
     * 第三种 DiscardOldestPolicy:将消息队列中的第一个任务替换为当前新进来的任务执行
     * 第四种 CallerRunsPolicy:直接调用execute来执行当前任务
     * 原文链接：https://blog.csdn.net/weixin_40271838/article/details/79998327
     */

    public static void main(String[] args) {
        MyTask myTask = new MyTask();
        /*Thread thread = new Thread(myTask);
        Thread thread2 = new Thread(myTask);
        thread.setName("线程");
        thread.start();
        thread2.start();*/

        for (int i = 0; i < 11; i++) {
            System.out.println("i=" + i);
            executor.execute(myTask);
            //System.out.println("核心线程数" + executor.getCorePoolSize());
            //System.out.println("最大线程数" + executor.getMaximumPoolSize());
            System.out.println("线程池中当前线程的数量" + executor.getPoolSize());
            System.out.println("队列任务数" + executor.getQueue().size());
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        }
        //executor.shutdown();
    }

    public static class MyTask implements Runnable {
        public void run() {
            synchronized (this) {
                System.out.println("name : " + Thread.currentThread().getName());
                System.out.println("count : " + (++count));
            }
            try {
                Thread.sleep(10L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
