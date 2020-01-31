fun main(args: Array<String>) {
    proses()
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
    val nama = readLine()!!
    print("""
    Jenis Kelamin Anda :
        (1) Laki-Laki
        (2) Perempuan
        (3) Transgender
        (4) Tidak Mau Menyebutkan
    Pilih : 
    """.trimIndent())
    var gender = readLine()!!
    when(gender){
        "1" -> gender = "Laki-Laki"
        "2" -> gender = "Perempuan"
        "3" -> gender = "Transgender"
        else -> gender = "Tidak Mau Menyebutkan"
    }
    print("Masukan Umur Anda : ")
    val umur = readLine()!!
    print("Masukan Asal Sekolah : ")
    val sekolah = readLine()!!
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
    val bidang = readLine()!!
    val out = output("$nama","$gender","$umur","$sekolah","$bidang")
    out.tampil()
    konfirmasi("$nama")
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
    if(yn == "y"){
        println("Succesfull")
        finish("$nama")
    }else{
        proses()
    }
}
fun finish(nama : String){
    println("""
    ***************************************************   
    * $nama ,SELAMAT ANDA SUDAH TERDAFTAR             *
    ***************************************************
    """.trimIndent())
}