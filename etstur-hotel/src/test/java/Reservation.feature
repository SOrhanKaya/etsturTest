Feature:  Hotel Reservation
  @ReservationStep
  Scenario:  Otel Rezervasyonu Senaryosu
    Given Anasayfa Açılır
    When Otel Araması Yapılır
    And Otel Seçilir
    And Oda Seçilir
    And Kişi Bilgileri Doldurulur
    And Ödeme Bilgileri Doldurulur
    Then Ödeme İçin İlerle Butonuna Tıklanır

