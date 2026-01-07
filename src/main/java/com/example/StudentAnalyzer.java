package com.example;

import java.util.List;

public class StudentAnalyzer {

    /**
     * Phân tích điểm số và trả về số lượng học sinh đạt loại Giỏi.
     * Logic: Duyệt list, check valid (0-10), check giỏi (>= 8.0).
     */
    public int countExcellentStudents(List<Double> scores) {
        if (scores == null || scores.isEmpty()) {
            return 0; // Xử lý danh sách rỗng
        }

        int count = 0;
        for (Double score : scores) {
            // Bỏ qua điểm null hoặc điểm không hợp lệ
            if (score != null && score >= 0 && score <= 10) {
                if (score >= 8.0) {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * Tính điểm trung bình hợp lệ.
     * Logic: Cộng tổng các điểm valid, đếm số lượng valid, rồi chia.
     */
    public double calculateValidAverage(List<Double> scores) {
        if (scores == null || scores.isEmpty()) {
            return 0.0;
        }

        double sum = 0;
        int validCount = 0;

        for (Double score : scores) {
            // Chỉ xử lý điểm hợp lệ
            if (score != null && score >= 0 && score <= 10) {
                sum += score;
                validCount++;
            }
        }

        // Tránh lỗi chia cho 0 nếu không có điểm nào hợp lệ
        if (validCount == 0) {
            return 0.0;
        }

        return sum / validCount;
    }
}
