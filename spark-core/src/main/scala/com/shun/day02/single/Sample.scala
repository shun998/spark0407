package com.shun.day02.single

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * Author layman
 * Date 2021/3/13 14:22
 */
object Sample {
    def main(args: Array[String]): Unit = {
        val conf: SparkConf = new SparkConf().setAppName("Sample").setMaster("local[2]")
        val sc: SparkContext = new SparkContext(conf)
        val list1 = 1 to 20
        val rdd1: RDD[Int] = sc.parallelize(list1, 2)
        // 参数1: 表示是否放回抽样.  false 比例[0, 1]
        //   true [0, 无穷)
        val rdd2 = rdd1.sample(true, 0)
        rdd2.collect.foreach(println)
        
        sc.stop()
    }
}
/*'
从RDD中进行抽样
 
 */
