package com.shun.day04.action

import org.apache.spark.{SparkConf, SparkContext}

/**
 * Author layman
 * Date 2021/3/16 9:18
 */
object CountByKey {
    def main(args: Array[String]): Unit = {
        val conf: SparkConf = new SparkConf().setAppName("ReduceByKey").setMaster("local[2]")
        val sc: SparkContext = new SparkContext(conf)
        val rdd1 = sc.parallelize(Array("hello", "hello", "world", "hello", "layman", "hello", "layman", "layman"))
//        val wordCount = rdd1.map((_, 1)).reduceByKey(_ + _).collect()
        val wordCount = rdd1.map((_, null)).countByKey()
        println(wordCount)
        
    }
}
