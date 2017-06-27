package org.apache.spark.h2o.converters

import org.apache.spark.h2o.{H2OContext, RDD}
import org.apache.spark.internal.Logging
import org.apache.spark.ml
import org.apache.spark.mllib.linalg.Vectors
import water.fvec.H2OFrame

private[converters] object MLVectorConverter extends Logging {


  /** Transform RDD[ml.linalg.Vector] to appropriate H2OFrame */
  def toH2OFrame(hc: H2OContext, rdd: RDD[ml.linalg.Vector], frameKeyName: Option[String]): H2OFrame = {
    // convert to mllib vector so we have single place in code where we handle this case
    MLLibVectorConverter.toH2OFrame(hc,rdd.map(Vectors.fromML), frameKeyName)
  }


}
