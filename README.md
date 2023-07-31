# MINE-SWEEPER
Mayın Tarlası Oyunu


MineSweeper sınıfı tanımlanıyor. Bu sınıf içinde Mayın Tarlası oyununun mantığı ve oyun için gerekli işlemler bulunuyor.

Scanner ve diğer gerekli değişkenler sınıf içinde tanımlanıyor.

Oyun alanını temsil edecek iki boyutlu diziler oluşturuluyor: mineMap ve board.

MineSweeper sınıfının yapıcı (constructor) metodu tanımlanıyor. Bu metod, kullanıcı tarafından belirtilen satır ve sütun sayılarına göre oyun alanını oluşturuyor ve dizi elemanlarını "-" ile dolduruyor.

randomSayi() metodu, mayınların rastgele konumlarını belirlemek için kullanılıyor. Random sınıfı ile rastgele satır ve sütun numaraları oluşturuyor.

fill(String[][] dizi) metodu, verilen iki boyutlu diziyi "-" ile dolduruyor.

isFind(String[][] arr, String value) metodu, belirli bir hücrede mayın olup olmadığını kontrol ediyor. Eğer o hücrede "*" yani mayın varsa false döndürüyor, yoksa true döndürüyor.

run() metodu, oyunun çalışma mantığını içeriyor. Mayınları yerleştiriyor, kullanıcıdan koordinat alıyor, oyun durumunu kontrol ediyor ve oyunun sonuçlarını ekrana yazdırıyor.

koordinatGir() metodu, kullanıcıdan koordinatları alıyor ve oyunun devam ettiği sürece oyuncuya puanlama yapma ve sonucu kontrol etme imkanı veriyor.

printMineMap() metodu, mayın haritasını ekrana yazdırıyor.

printBoard() metodu, oyun tahtasını ekrana yazdırıyor.
