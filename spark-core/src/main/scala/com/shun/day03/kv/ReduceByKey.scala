package com.shun.day03.kv

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * Author layman
 * Date 2021/3/14 10:05
 */
object ReduceByKey {
  def main(args: Array[String]): Unit = {
    val conf: SparkConf = new SparkConf().setMaster("local[2]").setAppName("ReduceByKey")
    val sc: SparkContext = new SparkContext(conf)
    val rdd1: RDD[String] = sc.parallelize(Array("hello", "hello", "world", "hello", "layman", "hello", "layman", "layman"))
    val wordOne: RDD[(String, Int)] = rdd1.map((_, 1))
    val rdd2: RDD[(String, Int)] = wordOne.reduceByKey(_ + _)
    rdd2.collect.foreach(println)
    sc.stop()

  }
}

/*
reduceByKey.
    1. 是一个聚合算子
    2. 和scala(reduce, foldLeft)的不一样, scala最终都是聚合成一个值
    3. spark的这个聚合, 是根据key来聚合的. 结果是和key的种类  k1, K1
    4. 先调整类型为 kv
 */
