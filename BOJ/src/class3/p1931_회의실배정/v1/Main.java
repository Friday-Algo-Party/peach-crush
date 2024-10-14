package class3.p1931_회의실배정.v1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Meeting> meetings = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            meetings.add(new Meeting(start, end));
        }

        Collections.sort(meetings);

        int cnt = 1;
        Meeting prevMeeting = meetings.get(0);

        for (int i = 1; i < meetings.size(); i++) {
            Meeting meeting = meetings.get(i);

            if(meeting.start >= prevMeeting.end) {
                prevMeeting = meeting;
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}

class Meeting implements Comparable<Meeting> {
    int start;
    int end;

    public Meeting(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Meeting o) {
        if(end == o.end) return Integer.compare(start, o.start);
        return Integer.compare(end, o.end);
    }
}
