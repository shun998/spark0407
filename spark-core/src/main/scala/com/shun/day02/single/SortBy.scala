package com.shun.day02.single

import org.apache.spark.{SparkConf, SparkContext}

/**
 * Author layman
 * Date 2021/3/13 15:42
 */
object SortBy {
    def main(args: Array[String]): Unit = {
        val conf: SparkConf = new SparkConf().setAppName("SortBy").setMaster("local[2]")
        val sc: SparkContext = new SparkContext(conf)
//        val list1 = List(30, 50, 70, 60, 10, 20)
        val list1 = List("aa", "ccc", "bdddd", "d", "b")
        val rdd1 = sc.parallelize(list1, 2)
//        val rdd2 = rdd1.sortBy(x => x, ascending = false)
//        val rdd2 = rdd1.sortBy(_ + "", false)
        val rdd2 = rdd1.sortBy(_.length, false)
        rdd2.collect.foreach(println)
        sc.stop()
        
    }
}
