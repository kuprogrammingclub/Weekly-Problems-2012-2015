-module(ip).
-export([conv/1]).

% load in erl shell with c("ip.erl").  <- with period
% usage : ip:conv(123456789).
% Erlang has sweet bit syntax for this type of stuff
conv(IP) -> << IP:32 >>.
% this is even pattern matchable
% << A, B, C, D >> = ip:conv(123456789).
