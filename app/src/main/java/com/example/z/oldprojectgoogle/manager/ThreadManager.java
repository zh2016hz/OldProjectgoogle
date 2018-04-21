package com.example.z.oldprojectgoogle.manager;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/*
 *  @项目名： 
 *  @包名：    试试
 *  @文件名:   ThreadManager
 *  @创建者:   试试
 *  @创建时间:  2017/11/23 11:27
 *  @描述：    线程管理类，管理线程池，一个应用中有多个线程池，每个线程池做自己相关的业务
 */
public class ThreadManager {

    private static ThreadPoolProxy mNormalPool = new ThreadPoolProxy(1, 3, 5 * 1000);
    private static ThreadPoolProxy mDownloadPool = new ThreadPoolProxy(3, 3, 5 * 1000);

    public static ThreadPoolProxy getNormalPool() {
        return mNormalPool;
    }

    public static ThreadPoolProxy getDownloadPool() {
        return mDownloadPool;
    }


    public static class ThreadPoolProxy {
        private final int mCorePoolSize;
        private final int mMaximumPoolSize;
        private final long mKeepAliveTime;
        private ThreadPoolExecutor mPool;


        public ThreadPoolProxy(int corePoolSize, int maximumPoolSize, long keepAliveTime) {
            this.mCorePoolSize = corePoolSize;
            this.mMaximumPoolSize = maximumPoolSize;
            this.mKeepAliveTime = keepAliveTime;
        }

        private void initPool() {
            if (mPool == null || mPool.isShutdown()) {
                //                int corePoolSize = 1;//核心线程池大小
                //                int maximumPoolSize = 3;//最大线程池大小
                //                long keepAliveTime = 5 * 1000;//保持存活的时间
                TimeUnit unit = TimeUnit.MILLISECONDS;//单位
                BlockingQueue<Runnable> workQueue = null;//阻塞队列

                                workQueue = new ArrayBlockingQueue<Runnable>(3);//FIFO,大小有限制
//                workQueue = new LinkedBlockingQueue();//
                //                workQueue = new PriorityBlockingQueue();

                ThreadFactory threadFactory = Executors.defaultThreadFactory();//线程工厂

                RejectedExecutionHandler handler = null;//异常捕获器

                //                handler = new ThreadPoolExecutor.DiscardOldestPolicy();//去掉队列中首个任务，将新加入的放到队列中去
                //                handler = new ThreadPoolExecutor.AbortPolicy();//触发异常
                handler = new ThreadPoolExecutor.DiscardPolicy();//不做任何处理
                //                handler = new ThreadPoolExecutor.CallerRunsPolicy();//直接执行，不归线程池控制,在调用线程中执行

                //                new Thread(task).start();

                mPool = new ThreadPoolExecutor(mCorePoolSize,
                        mMaximumPoolSize,
                        mKeepAliveTime,
                        unit,
                        workQueue,
                        threadFactory,
                        handler);
            }
        }

        /**
         * 执行任务
         *
         * @param task
         */
        public void execute(Runnable task) {
            initPool();

            //执行任务
            mPool.execute(task);
        }


        public Future<?> submit(Runnable task) {
            initPool();
            return mPool.submit(task);
        }

        public void remove(Runnable task) {
            if (mPool != null && !mPool.isShutdown()) {
                mPool.getQueue()
                        .remove(task);
            }
        }

    }
}