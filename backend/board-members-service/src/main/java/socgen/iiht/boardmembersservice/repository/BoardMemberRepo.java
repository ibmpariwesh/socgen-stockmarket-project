package socgen.iiht.boardmembersservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import socgen.iiht.boardmembersservice.model.BoardMember;

@Repository
public interface BoardMemberRepo extends JpaRepository<BoardMember,Integer> {
    public void deleteBoardMemberById(int id);
}
