Feature: Order Makanan di Restoran

  Scenario: Pelanggan Memesan Makanan
    Given Pelanggan Duduk di Restoran
    When Pelanggan Melihat Menu
    And Pelayan Mencatat Order
    And Pelayan Memberikan Order ke Dapur
    And Dapur Memasak Makanan
    Then Makanan Siap Disajikan
    And Pelayan Memberikan Kepada Pelanggan
    And Pelanggan Menikmati
    And Pelanggan Membayar