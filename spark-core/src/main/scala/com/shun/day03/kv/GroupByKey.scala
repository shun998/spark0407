package com.shun.day03.kv

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * Author layman
 * Date 2021/3/14 10:18
 */
object GroupByKey {
  def main(args: Array[String]): Unit = {
    val conf: SparkConf = new SparkConf().setMaster("local[2]").setAppName("GroupByKey")
    val sc: SparkContext = new SparkContext(conf)
    val rdd1: RDD[String] = sc.parallelize(Array("hello", "hello", "world", "hello", "layman", "hello", "layman", "layman"))
    val wordOne: RDD[(String, Int)] = rdd1.map((_, 1))
    val wordOneGrouped = wordOne.groupByKey().mapValues(_.sum)
    wordOneGrouped.collect.foreach(println)
    sc.stop()

  }
}

/*
groupByKey
    1. 分组. 按照Key进行分组
    2. groupBy(x => ..) 按照返回值来分
    3. groupByKey只能用户kv形式的
    4. groupBy任意RDD都可以使用

 */