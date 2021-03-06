package jpql;

import javax.persistence.*;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {

                Team team = new Team();
                team.setName("teamA");
                em.persist(team);

                Member member = new Member();
                member.setUsername(null);
                member.setAge(10);
                member.setType(MemberType.ADMIN);

                member.setTeam(team);

                em.persist(member);


            em.flush();
            em.clear();

            String query = "select coalesce(m.username, '이름 없는 회원') as username " +
                    "from Member m";
            List<String> result = em.createQuery(query, String.class)
                    .getResultList();

            for (String s : result) {
                System.out.println("s = " + s);
            }

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }

        emf.close();
    }
}
