package com.blogify.blogapi.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class FollowRequest {

    private Integer fromUserId;
    private Integer toUserId;


}
