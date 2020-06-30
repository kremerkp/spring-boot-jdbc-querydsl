package lu.eyet.dev.jdbcsandbox.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Service;

import lu.eyet.dev.jdbcsandbox.model.Movie;
import lu.eyet.dev.jdbcsandbox.repository.MovieRepository;

@Service
@NoRepositoryBean
public class ReportService {

    @Autowired
    private MovieRepository movieRepository;

    public String exportReport(String reportFormat) {
        List<Movie> movies = new ArrayList<>();
        Iterable<Movie> mov = movieRepository.findAll();
        return null;
    }

}