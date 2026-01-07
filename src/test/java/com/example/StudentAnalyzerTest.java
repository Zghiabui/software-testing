
package com.example;
import org.junit.jupiter.api.Test; // JUnit 5
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class StudentAnalyzerTest {

    private final StudentAnalyzer analyzer = new StudentAnalyzer();

    // --- Test cho hàm đếm học sinh giỏi ---

    @Test
    public void testCountExcellentStudents_MixedValues() {
        // Kịch bản: Có điểm giỏi, điểm khá, điểm sai (<0, >10)
        List<Double> scores = Arrays.asList(9.0, 8.0, 7.9, 11.0, -5.0, 10.0);
        // Kỳ vọng: 9.0 (Giỏi), 8.0 (Giỏi), 10.0 (Giỏi) -> Tổng 3
        assertEquals(3, analyzer.countExcellentStudents(scores), "Phải đếm đúng 3 điểm giỏi hợp lệ");
    }

    @Test
    public void testCountExcellentStudents_EmptyList() {
        // Kịch bản: Danh sách rỗng
        assertEquals(0, analyzer.countExcellentStudents(Collections.emptyList()), "List rỗng phải trả về 0");
    }

    @Test
    public void testCountExcellentStudents_AllInvalid() {
        // Kịch bản: Toàn điểm sai
        assertEquals(0, analyzer.countExcellentStudents(Arrays.asList(-1.0, 11.0, 100.0)), "Không có điểm hợp lệ nào");
    }

    // --- Test cho hàm tính trung bình ---

    @Test
    public void testCalculateValidAverage_Standard() {
        // Kịch bản: 9.0, 8.5, 7.0, 11.0 (bỏ), -1.0 (bỏ)
        // Hợp lệ: 9.0 + 8.5 + 7.0 = 24.5
        // Số lượng: 3
        // Trung bình: 24.5 / 3 = 8.16666...
        List<Double> scores = Arrays.asList(9.0, 8.5, 7.0, 11.0, -1.0);

        // Lưu ý: So sánh số thực (double) phải có delta (sai số cho phép), ở đây đề bài cho 0.01
        assertEquals(8.166, analyzer.calculateValidAverage(scores), 0.01);
    }

    @Test
    public void testCalculateValidAverage_Boundary() {
        // Kịch bản: Biên 0 và 10
        List<Double> scores = Arrays.asList(0.0, 10.0);
        // TB: (0+10)/2 = 5.0
        assertEquals(5.0, analyzer.calculateValidAverage(scores), 0.001);
    }

    @Test
    public void testCalculateValidAverage_NoValidScores() {
        // Kịch bản: List có phần tử nhưng toàn không hợp lệ -> Tránh chia cho 0
        List<Double> scores = Arrays.asList(-5.0, 20.0);
        assertEquals(0.0, analyzer.calculateValidAverage(scores), "Không có điểm hợp lệ thì TB là 0");
    }
}
