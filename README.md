### Program Pemesanan Restaurant Online

#### Deskripsi program

Program pemesanan restaurant online merupakan program yang dapat digunakan untuk
memesan menu baik itu makanan dan minuman. Program ini terdapat dua *user* yaitu admin dan customer. Admin dapat menambahkan restaurant dan menambahkan menu sedangkan customer dapat memesan makanan dan melihat pesanan.

#### Alur program

Program ini bertujuan untuk memanajemen dan membuat sistem pemesanan makanan secara *online*. Beberapa alur dari program ini dari login menjadi customer dan admin.

##### Login

Login pada program ini dibuat secara *Hardcoded* yang berarti *username* dan *password* sudah terprogram secara langsung ke dalam program tanpa mengambil data dari eksternal seperti *database*.

*Credential* untuk login :

**Admin**

*username* : admin

*password* : admin

**Customer**

*username* : customer

*password* : customer

**Admin**

Admin memiliki 5 opsi yaitu melihat restaurant, menambah restaurant, menghapus restaurant, menambah menu dan melihat menu. Admin disini dapat memanajemen hal" yang akan diakses oleh customer nantinya seperti restaurant dan menu dari restaurant. Data seperti menu dan restaurant akan diinput oleh admin dan data tersebut akan bertahan hingga program berhenti.

**Customer**

Customer memiliki 4 opsi yaitu melihat restaurant, melihat menu, membuat pesanan dan melihat pesanan. Customer utamanya sebagai pemesan dari apa yang telah admin tambahkan terutama menu, jadi jika belum terdapat menu maka customer tidak dapat memesan. Customer dapat memesan menu yang sudah tersedia sesuai restaurant dan dapat melihat pesanan setiap restaurant beserta harga yang harus dibayarkan. 

#### Fitur

1. Penghitungan harga berdasarkan jarak customer
2. Dapat memilih restaurant ketika memesan menu
3. Dapat melihat riwayat pemesanan sesuai restaurant dan harga yang harus dibayarkan

#### UML

UML dari program ini dapat dilihat di sini.

#### Persyaratan Sistem

- Java versi 11
- Sistem operasi (Windows, MacOS, Linux)
- Intellij IDEA Community Edition

#### Instalasi

1. Unduh file instalasi dari [sini](https://github.com/ikadeknandasanjaya/restaurant/raw/master/assets/jar/restaurant_jar.zip).
2. Ekstrak file instalasi ke direktori yang diinginkan.
3. Buka terminal atau command prompt dan arahkan ke direktori tempat file instalasi diekstrak.
4. Jalankan program dengan perintah 'java -jar restaurant.jar'.

#### Cara Penggunaan

##### Menjalankan Program

1. Buka terminal atau command prompt dan arahkan ke direktori tempat file program diekstrak.
2. Jalankan program dengan perintah java -jar restaurant.jar.
3. Ikuti instruksi yang muncul di layar.

#### Contoh Penggunaan

1. Jalankan program dengan perintah java -jar nama-program.jar.
2. Pilih akan login sebagai admin atau customer.
3. Login sebagai admin terlebih dahulu untuk menambah restaurant dan menu.
4. Login sebagai admin dengan memasukan username dan password yaitu 'admin'.
5. Tambah restaurant terlebih dahulu dengan memasukan id restaurant, nama restaurant dan alamat restaurant. Setelah itu bisa kembali ke menu admin.
6. Lalu tambahkan menu pada restaurant tersebut dengan memasukan id menu, nama menu, jenis menu dan harga menu.
7. Setelah terdapat restaurant dan menu. Kembalilah ke halaman login utama.
8. Sekarang kita login sebagai customer dengan memasukan username dan password yaitu 'customer'.
9. Buat pesanan pada restaurant yang telah dibuat sebelumnya dan pilih menu yang akan dipesan. Lalu masukan jumlah pesan dan jarak rumah dalam KM.
10. Setelah membuat pesanan, lihatlah pesanan sesuai dengan resturant yant telah dibuat sebelumnya dengan berisikan detail pesanan seperti harga pesanan.






