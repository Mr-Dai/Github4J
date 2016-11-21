package com.github4j.json;

import com.github4j.git.GitCommit;
import com.github4j.util.TestUtils;
import org.joda.time.LocalDateTime;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

public class GitCommitTest extends JsonEntityParsingTest {

    @Test
    public void testGitCommit() {
        String testFile = TestUtils.readResource("json/git_commit.json");
        GitCommit gitCommit = gson.fromJson(testFile, GitCommit.class);
        assertThat(gitCommit.getSha(), is("fe554a5d570891a6eddb13f5b254e4591e11b13f"));
        assertThat(gitCommit.getAuthor(), notNullValue());
        assertThat(gitCommit.getAuthor().getName(), is("Robert Peng"));
        assertThat(gitCommit.getAuthor().getEmail(), is("robert.peng@foxmail.com"));
        assertThat(gitCommit.getAuthor().getDate(), is(LocalDateTime.parse("2016-11-20T04:12:05")));
        assertThat(gitCommit.getCommitter(), notNullValue());
        assertThat(gitCommit.getCommitter().getName(), is("Robert Peng"));
        assertThat(gitCommit.getCommitter().getEmail(), is("robert.peng@foxmail.com"));
        assertThat(gitCommit.getCommitter().getDate(), is(LocalDateTime.parse("2016-11-20T04:12:05")));
        assertThat(gitCommit.getTree(), notNullValue());
        assertThat(gitCommit.getTree().getSha(), is("2212b7291efab9d4850348c40e0b765525208ed5"));
        assertThat(gitCommit.getMessage(), is("Initialized project"));
        assertThat(gitCommit.getParents(), notNullValue());
        assertThat(gitCommit.getParents().size(), is(1));
        assertThat(gitCommit.getParents().get(0).getSha(), is("39626b3d77b0bfebf48dd08ea88aebe426a1e76f"));
    }
}
