# Zoo REST API Project

Bu proje, bir hayvanat bahçesi yönetim sisteminin temelini oluşturan, Spring Boot kullanılarak geliştirilmiş bir RESTful API uygulamasıdır. Kangaroo ve Koala türündeki hayvanların CRUD işlemlerini yönetir ve merkezi bir hata yönetim sistemi sunar.

## Ozellikler

* RESTful CRUD: Kangaroo ve Koala varlıkları için tam işlevsel endpointler.
* Merkezi Hata Yonetimi: @ControllerAdvice ile tüm hatalar tek bir noktadan yakalanır ve standart bir ZooErrorResponse formatında donulur.
* Lombok Entegrasyonu: Boilerplate kodları (getter, setter, constructors) azaltmak için Lombok kullanılmıştır.
* Ozel Port Yapılandırması: Uygulama varsayılan olarak 9000 portunda ve /workintech context-path'i ile çalışır.

## Kullanılan Teknolojiler

* Java 17+
* Spring Boot 3.x
* Project Lombok
* JUnit 5 ve MockMvc

## Paket Yapısı

com.workintech.zoo
├── controller    # REST Controller siniflari
├── entity        # Veri modelleri (Kangaroo, Koala)
├── exceptions    # Ozel hata siniflari ve Global Handler
└── MainApplication.java

## API Endpointleri

Uygulama çalıştıktan sonra aşağıdaki endpointler üzerinden erişim sağlanabilir (Base URL: http://localhost:9000/workintech):

### Kangaroo Islemleri
- GET /kangaroos: Tum kangurulari listeler.
- GET /kangaroos/{id}: Belirli bir ID'ye sahip kanguruyu getirir.
- POST /kangaroos: Yeni bir kanguru ekler.
- PUT /kangaroos/{id}: Mevcut bir kanguruyu günceller.
- DELETE /kangaroos/{id}: Bir kanguruyu siler.

### Koala Islemleri
- GET /koalas: Tum koalaları listeler.
- GET /koalas/{id}: Belirli bir ID'ye sahip koalayı getirir.
- POST /koalas: Yeni bir koala ekler.
- PUT /koalas/{id}: Mevcut bir koalayı günceller.
- DELETE /koalas/{id}: Bir koalayı siler.

## Hata Yonetimi Ornegi

Eger gecersiz bir ID ile sorgu yapilirsa veya bir hata olusursa uygulama su formatta bir cevap doner:

{
  "status": 404,
  "message": "Kangaroo not found",
  "timestamp": 1703491200000
}

## Kurulum ve Calistirma

1. Projeyi klonlayin:
   git clone https://github.com/kullaniciadi/zoo-rest-api.git

2. Proje dizinine gidin:
   cd zoo-rest-api

3. Uygulamayi calistirin:
   mvn spring-boot:run
