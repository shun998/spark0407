package com.shun.day02.single

import org.apache.spark.{SparkConf, SparkContext}

/**
 * Author layman
 * Date 2021/3/13 13:51
 */
object FlatMap {
    def main(args: Array[String]): Unit = {
        val conf: SparkConf = new SparkConf().setAppName("FlatMap").setMaster("local[2]")
        val sc: SparkContext = new SparkContext(conf)
        /*val list1 = List(1 to 3, 1 to 5, 10 to 20)
        val rdd1 = sc.parallelize(list1, 2)
        
       val rdd2 =  rdd1.flatMap(x => x)*/
        
        val list1 = List(30, 5, 70, 6, 1, 20)
        val rdd1 = sc.parallelize(list1)
        // rdd2中存储这些元素和他们的平方, 三次方
        //        val rdd2 = rdd1.flatMap(x => List(x, x * x, x* x * x))
        // rdd2只要偶数和偶数的平方,三次方
        val rdd2 = rdd1.flatMap(x => if (x % 2 == 0) List(x, x * x, x * x * x) else List[Int]())
        rdd2.collect.foreach(println)
        
        sc.stop()
        
    }
}

/*
flatMap

*/
