package hello1.hellospring1;


import hello1.hellospring1.repository.JdbcMemberRepository;
import hello1.hellospring1.repository.MemberRepository;
import hello1.hellospring1.repository.MemoryMemberRepository;
import hello1.hellospring1.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
    public class SpringConfig {

    private final DataSource dataSource;

    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }
        @Bean
        public MemberRepository memberRepository() {
            // return new MemoryMemberRepository();
            return new JdbcMemberRepository(dataSource);
        }
}
