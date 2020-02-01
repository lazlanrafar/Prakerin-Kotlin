fun main(args: Array<String>) {
    proses()
    val robot = chatbot()
    robot.help()
}
fun proses(){
    println("""
    =================================================
         SELAMAT DATANG CALON PESERTA DIDIK BARU      
                         2020/2021
    +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
          ISI FORMULIR PENDAFTARAN DI BAWAH INI
                            |
                            |
                            -

    """.trimIndent())
    print("Masukan Nama Anda : ")
    val nama = readLine()
    print("""
    Jenis Kelamin Anda :
        (1) Laki-Laki
        (2) Perempuan
        (3) Transgender
        (4) Tidak Mau Menyebutkan
    Pilih : 
    """.trimIndent())
    var gender = readLine()
    when(gender){
        "1" -> gender = "Laki-Laki"
        "2" -> gender = "Perempuan"
        "3" -> gender = "Transgender"
        "4" -> gender = "Tidak Mau Menyebutkan"
    }
    print("Masukan Umur Anda : ")
    val umur = readLine()
    print("Masukan Asal Sekolah : ")
    val sekolah = readLine()
    print("""
    +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+

    --------- Pilih Bidang Yang Anda Minati ---------

        (1) Web Design
        (2) Networking Support
        (3) Software Dev     
        (4) Cyber Securty

    +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
    Pilih : 
    """.trimIndent())
    val bidang = readLine()
    val kosong = nullable("$nama","$gender","$umur","$sekolah","$bidang")
    kosong.check()

}
class nullable(val nama : String?,val gender : String?,val umur : String?,val sekolah : String?,val bidang : String?){
    fun check(){
        if(nama == null || gender == null || umur == null || sekolah == null || bidang == null){
            print("Anda Belum Memasukan Data dengan benar")
            System.exit(-1)
        }else{
            val out = output("$nama","$gender","$umur","$sekolah","$bidang")
            out.tampil()
            konfirmasi("$nama")
        }
    }
}
class output(val nama : String,val gender : String,val umur : String,val sekolah : String,val bidang : String){
    val pilih = mapOf<String,String>(
        "1" to "Web Design",
        "2" to "Networking Support",
        "3" to "Software Development",
        "4" to "Cyber Securty"
    )
    fun tampil(){
        val fix = pilih.getValue("$bidang")
        println("""
        *************************************************    
        Nama : $nama
        Gender : $gender
        Umur : $umur
        Asal Sekolah : $sekolah
        Bidang : $fix
        *************************************************
        """.trimIndent())
    }
}
fun konfirmasi(nama : String){
    print("Apakah data yang dimasukan Benar?(y/n):")
    val yn = readLine()
    if(yn == "y" || yn == "Y"){
        println("Succesfull")
        finish("$nama")
    }else{
        proses()
    }
}
fun finish(nama : String){
    val name : String = nama.toUpperCase()
    println("""
    *************************************************** 
    *  
    *       $name ,SELAMAT ANDA SUDAH TERDAFTAR             
    *
    ***************************************************
    """.trimIndent())
}
class chatbot(){
    fun help(){
        print("Apakah Ada Pertanyaan ?(y/n)")
        val faq = readLine()
        if(faq == "y" || faq == "Y"){
            quest()
        }else{
            print("Terima Kasih Telah Berlangganan dengan kami")
        }
    }
    fun quest(){
        print("-> ")
        val anda = readLine()
        answer("$anda")
    }
    fun answer(anda : String){
        when(anda){
            "kenapa harus disini" -> println("Karena Disi telah terakreditasi A")
            "apa keunggulan disini" -> println("lulusan sini dah ke luar negri")
            "quit" -> quit()
            else -> println("Pertanyaan tidak ditemukan")
        }
        quest()
    }
    fun quit(){
        print("Sayonara")
        System.exit(-1)
    }
}