import org.apache.spark.SparkConf
import org.apache.spark.streaming.{Seconds, StreamingContext}

object Driver {

  def main(args: Array[String]): Unit = {

    val streamConf = new SparkConf().setMaster("local[*]")
                                .setAppName("spark sample streaming")

    val stream = new StreamingContext(streamConf,Seconds(5))

    val lines =stream.receiverStream(new JavaCustomSocketReceiver("localhost",9999))

    val words =lines.flatMap(_.split(" "))

    val wordPair =words.map(word=>(word,1))

   val count = wordPair.reduceByKey(_+_)

    count.print()

    stream.start()
    stream.awaitTermination()



  }

}
