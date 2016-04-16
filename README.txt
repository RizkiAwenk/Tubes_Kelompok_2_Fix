SISFO PENDAFTARAN GELADI Version 1.0 16/04/2016

FEATURES of the PROGRAM
=======================
SISFO PENDAFTARAN GELADI adalah sebuah aplikasi versi pertama
dari kelompok IF3802. Aplikasi ini bernama Sistem Informasi Pendaftaran Geladi. 
Aplikasi ini bertujuan untuk mempercepat proses pendaftaran geladi mahasiswa universitas telkom, 
Didalam aplikasi ini terdapat 4 menu yaitu menu Lokasi, menu Kelompok
menu Pembimbing dan menu Mahasiswa. 
Penjelasan Singkat:
1. Klik Button Masuk
2. lalu akan memasukai Halaman Utama
3. kemudian pilih salah satu mennu dan memasukan setiap data yang diminta
4. Setiap menu memiliki tampilan yang tidak jauh berbeda
5. lakukan langkah 2 dan 3 
6. selesai.

Minimum System Requirement
===========================
Microsoft Windows XP Professional SP3/Vista SP1/Windows 7 Professional:
 - Processor: 2.6 GHz Intel Pentium IV or equivalent
 - Memory: 2 GB
 - Disk space: 1 GB of free disk space
NetBeans IDE 7.0.1 :
 - Full certification on the final release of JDK 7
 - Bundle GlassFish 3.1.1 update release
 - WebLogic related enhancements
 - Significant quality increase


Class Diagram
=============
------------------
|Orang <Abstract>| 
------------------
| nama : String	 |
|		 |
------------------
	^	
	|-----------------------------|
	|			      |
------------------            ------------------
|   Mahasiswa    | 	      |   Pembimbing   |
------------------	      ------------------
| kelas : String |	      | nip : long     |
| nim : long	 |            |                |
------------------            ------------------
	|			      |
        ^			      ^
	V			      V
----------------------            -----------------------
|    Kelompok         | 	  |     Lokasi           |
----------------------|	          ------------------------
| anggota:Mahasiswa[] |	          | pembimbing:pembimbing|
| nama kelompok:string|           | kelompok:kelompok[]  |
| jumlah anggota:int  |           | nama lokasi:string   |	
-----------------------           ------------------------




Contact and copyright
=====================
awawaw407@gmail.com